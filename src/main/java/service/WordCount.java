package service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.StructType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import scala.util.parsing.json.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.spark.sql.functions.*;

@Component
public class WordCount {

	@Autowired
	private SparkSession sparkSession;

	public List<MemoriaEquipRede> aplicaFiltro(Filtro filtro) {
		StructType schema = new StructType()
				.add("periodoInicio", "string")
				.add("periodoFinal", "string")
				.add("nome", "string")
				.add("estado", "string")
				.add("cidade", "string")				
				.add("modelo", "string")
				.add("porcentagem", "double");

		Dataset<MemoriaEquipRede> df = sparkSession.read()
				.option("header", "true")
				.option("delimiter", ";")
				.option("mode", "DROPMALFORMED").schema(schema)
				.csv("/home/luis/Downloads/memoriarmx.csv")
				.as(Encoders.bean(MemoriaEquipRede.class));
		
		if(filtro.getNome() != null) {
			df = df.filter(col -> col.getNome().contains(filtro.getNome()));
		}
		if(filtro.getCidade() != null) {
			df = df.filter(col -> col.getCidade().contains(filtro.getCidade()));
		}
		if(filtro.getEstado() != null) {
			df = df.filter(col -> col.getEstado().contains(filtro.getEstado()));
		}
		if(filtro.getModelo() != null) {
			df = df.filter(col -> col.getModelo().contains(filtro.getModelo()));
		}
		
		return df.collectAsList(); 
		
	}
	
	public List<MemoriaDTO> buscaQuantidadeEquipamentoPorEstado() {
		StructType schema = new StructType()
				.add("periodoInicio", "string")
				.add("periodoFinal", "string")
				.add("nome", "string")
				.add("estado", "string")
				.add("cidade", "string")				
				.add("modelo", "string")
				.add("porcentagem", "double");

		Dataset<MemoriaEquipRede> df = sparkSession.read()
				.option("header", "true")
				.option("delimiter", ";")
				.option("mode", "DROPMALFORMED").schema(schema)
				.csv("/home/luis/Downloads/memoriarmx.csv")
				.as(Encoders.bean(MemoriaEquipRede.class));
		
		RelationalGroupedDataset x = df.groupBy("estado");
		
		List<Row> rows = x.count().collectAsList(); 
		Stream<MemoriaDTO> f = rows.stream().map(new Function<Row, MemoriaDTO>() {
          @Override
	         public MemoriaDTO apply(Row row) {
	              return new MemoriaDTO(row.getString(0), row.getLong(1));
	          }
	      });
		return f.collect(Collectors.toList());
		
	}
	
	public List<MemoriaDTO> buscaMEdiaDeUsoPorEstado() {
		StructType schema = new StructType()
				.add("periodoInicio", "string")
				.add("periodoFinal", "string")
				.add("nome", "string")
				.add("estado", "string")
				.add("cidade", "string")				
				.add("modelo", "string")
				.add("porcentagem", "double");

		Dataset<MemoriaEquipRede> df = sparkSession.read()
				.option("header", "true")
				.option("delimiter", ";")
				.option("mode", "DROPMALFORMED").schema(schema)
				.csv("/home/luis/Downloads/memoriarmx.csv")
				.as(Encoders.bean(MemoriaEquipRede.class));
		
		List<Row> x = df.groupBy("estado").avg("porcentagem").collectAsList();
		
		return x.stream().map(new Function<Row, MemoriaDTO>() {
          @Override
          public MemoriaDTO apply(Row row) {
          	df.show();
              return new MemoriaDTO(row.getString(0), row.getDouble(1));
          }
      }).collect(Collectors.toList());
		
	}
}
