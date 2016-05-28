# WSCiudadano
WebService SOAP para ciudadanos

	Creada utilizando Netbeans 8.1, Java 8, JUnit 4, MAVEN, GlassFish 4.1, PrimeFaces 5.0, Mysql community 5.7.12.0.

**SQL para crear la base de datos**
```sql
	CREATE DATABASE `db_ciudadanos` /*!40100 DEFAULT CHARACTER SET utf8 */;

    USE `db_ciudadanos`;
    
    CREATE TABLE `opdc` ( /*Objeto Persona de Ciudad*/
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `nombre` varchar(50) NOT NULL,
      `apellido` varchar(75) NOT NULL,
      `sexo` char(1) NOT NULL,
      `fecha_nacimiento` date NOT NULL,
      `direccion` varchar(200) DEFAULT NULL,
      `correo_electronico` varchar(200) NOT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
    
    CREATE TABLE `pdct` ( /*Persona de Ciudada Telefono*/
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `opdc_id` int(11) NOT NULL,
      `linea` int(11) NOT NULL,
      `telefono` varchar(10) NOT NULL,
      PRIMARY KEY (`id`),
      KEY `fk_opdc_id_idx` (`opdc_id`),
      CONSTRAINT `fk_opdc_id` FOREIGN KEY (`opdc_id`) REFERENCES `opdc` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

**Instalación del pool y rource**
  
  Pasos para hacerlo desde Glassfish:
  
  1.  ir a http://localhost:4848/ y iniciar sesion.
  2.  En el panel de la izquierda "Common Task" => Resource => JDBC.
  3.  En JDBC Connection Pool crear nuevo con las siguientes caracteristicas:
  4.  Pool Name: mysqlPool
  5.  Resource Type: javax.sql.DataSource
  6.  Datasource Classname: com.mysql.jdbc.jdbc2.optional.MysqlDataSource
  7.  Agregar estas Propiedades:
  8.  User: root
  9.  Password: root
  10.  PortNumber: 3306
  11.  ServerName: mysqlserver
  12.  DatabaseName: db_ciudadanos
  13.  URL: jdbc:mysql://mysqlserver:3306/db_ciudadanos
  14.  Guardar el pool creado.
  15.  En JDBC Resource crear uno nuevo con las siguientes caracteristicas:
  16.  JNDI Name: mysql
  17.  Pool Name: mysqlPool
  18.  Guardar el resource creado.
  
  
  

  
