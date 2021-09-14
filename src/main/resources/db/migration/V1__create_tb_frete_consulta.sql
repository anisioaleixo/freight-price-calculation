CREATE TABLE IF NOT EXISTS `tb_frete_consulta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cep_destino` varchar(8) NOT NULL,
  `cep_origem` varchar(8) NOT NULL,
  `data_consulta` date NOT NULL,
  `data_prevista_entrega` date NOT NULL,
  `nome_destinatario` varchar(60) NOT NULL,
  `peso` double NOT NULL,
  `vl_total_frete` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
);