insert into tb_colisao (nome, descricao, data_colisao, velocidade_impacto, qtd_lixos_gerados) values ('Iridium-33 vs. Kosmos-2251', 'Satélite comercial de comunicações americano ativo (Iridium-33) e o satélite militar russo desativado (Kosmos-2251)', '2009-02-10', 42120, 2300)
insert into tb_colisao (nome, descricao, data_colisao, velocidade_impacto, qtd_lixos_gerados) values ('Missão DART vs. Asteroide Dimorphos','Sonda espacial da NASA (DART) contra a superfície do asteroide natural Dimorphos', '2002-09-22', 23000, 100)
insert into tb_colisao (nome, descricao, data_colisao, velocidade_impacto, qtd_lixos_gerados) values ('Míssil Chinês vs. Fengyun-1C', 'Míssil balístico cinético interceptador lançado da Terra pela China contra o satélite meteorológico chinês desativado Fengyun-1C', '2007-01-11', 28800, 3500)
insert into tb_colisao (nome, descricao, data_colisao, velocidade_impacto, qtd_lixos_gerados) values ('Satélite Cerise vs. Fragmento do Foguete Ariane 1', 'Satélite militar de reconhecimento francês ativo (Cerise) e um fragmento catalogado vindo da explosão do estágio superior de um foguete europeu Ariane 1', '1996-07-24', 52200, 1)

insert into tb_lixo_espacial (risco, tipo, data_aparicao, peso, id_colisao) values ('Baixo', 'SATELITE', '2026-05-31', 0.5, 1)
insert into tb_lixo_espacial (risco, tipo, data_aparicao, peso, id_colisao) values ('Alto', 'FRAGMENTO', '2026-05-31', 5000, 2)
insert into tb_lixo_espacial (risco, tipo, data_aparicao, peso, id_colisao) values ('Baixo', 'SATELITE', '2026-05-31', 3, 3)
insert into tb_lixo_espacial (risco, tipo, data_aparicao, peso, id_colisao) values ('Médio', 'FOGUETE', '2026-05-31', 4, 4)
