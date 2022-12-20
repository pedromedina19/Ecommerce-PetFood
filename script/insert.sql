
INSERT INTO public.papel(
	id, nome)
	VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.papel(
	id, nome)
	VALUES (2, 'ROLE_FUNCIONARIO');
INSERT INTO public.papel(
	id, nome)
	VALUES (3, 'ROLE_CLIENTE');
INSERT INTO public.usuario(
	codigo, ativo, data_nascimento, email, nome, nome_usuario, senha)
	VALUES (100, true, '2002-03-19', 'pedro@gmail.com', 'Pedro Medina', 'pedro', '$2a$12$9jVdggsxSi/oa5AsbiojOOUVjk6ZXzymuy4MUZ0Hv8QEbYO0fq5nm');
INSERT INTO public.usuario(
	codigo, ativo, data_nascimento, email, nome, nome_usuario, senha)
	VALUES (200, true, '1998-08-20', 'rafaelcaroni@gmail.com', 'Rafael Caroni', 'rafaelcaroni', '$2a$12$FwVu70dVkFKB9vneDraNZ.dKKvXTv06/eKlq3Zn7fczdvrU36qWKi');
INSERT INTO public.usuario(
	codigo, ativo, data_nascimento, email, nome, nome_usuario, senha)
	VALUES (300, true, '1980-08-20', 'rafaelorbolato@gmail.com', 'Rafael Orbolato', 'rafaelorbolato', '$2a$12$xiQhBJDtQkk3Z6NwVfAwtOmg8lU0SMvFez53cf/pvLiWuw1zvbFEm');
INSERT INTO public.usuario_papel(
	codigo_usuario, codigo_papel)
	VALUES (100, 1);
INSERT INTO public.usuario_papel(
	codigo_usuario, codigo_papel)
	VALUES (200, 2);
INSERT INTO public.usuario_papel(
	codigo_usuario, codigo_papel)
	VALUES (300, 3);
INSERT INTO public.marca(
	id, descricao, imagem, nome, status)
	VALUES (100, '', 'https://www.petlove.com.br/images/brands/logo/223547/normal/premierpet.jpg?1588169415', 'Premier', 'ATIVO');
INSERT INTO public.marca(
	id, descricao, imagem, nome, status)
	VALUES (200, '', 'https://www.petlove.com.br/images/brands/logo/206895/normal/RC_logo_2016cmjn.jpg?1556295210', 'Royal Canin', 'ATIVO');
INSERT INTO public.marca(
	id, descricao, imagem, nome, status)
	VALUES (300, '', 'https://www.petlove.com.br/images/brands/logo/232580/normal/Logo_F%C3%B3rmula_Natural.jpg?1606768535', 'Formula natural]', 'ATIVO');
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (100, 'CAES', 220.49, '- Pelagem bonita e pele saudável: rico em proteínas de alta qualidade e equilíbrio ideal de ácidos graxos essenciais - ômegas 3 e 6;', 'Ração Premier Pet Ambientes Internos Cães Filhotes Frango e Salmão', 'https://www.petlove.com.br/images/products/261768/product/Ra%C3%A7%C3%A3o_Premier_Pet_Ambientes_Internos_C%C3%A3es_Filhotes_Frango_e_Salm%C3%A3o_-_12_Kg_3108262-3.jpg?1662044527', 10, 5, 'ATIVO', 250.99, 100);
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (101, 'CAES', 285.21, '- Alimento rico em nutrientes, promove a pelagem bonita e pele saudável;
- Combinação de ingredientes de alta digestibilidade, fibras especiais e prebiótico;', 'Ração Premier Pet Formula Cães Adultos Raças Pequenas', 'https://www.petlove.com.br/images/products/261741/product/Ra%C3%A7%C3%A3o_Premier_Pet_Formula_C%C3%A3es_Adultos_Ra%C3%A7as_Pequenas_-_20_Kg_3108224-3_4.jpg?1662042965', 20, 10, 'ATIVO', 285.21, 100);
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (102, 'GATOS', 119.49, '- Sabor inigualável: promove máxima satisfação para paladares exigentes;', 'Ração Seca PremieR Pet Golden Salmão para Gatos Adultos Castrados', 'https://www.petlove.com.br/images/products/261684/product/Ra%C3%A7%C3%A3o_Seca_PremieR_Pet_Golden_Salm%C3%A3o_para_Gatos_Adultos_Castrados_-_10_1_Kg_31022435-3_2.jpg?1662035152', 10, 5, 'ATIVO', 159.21, 100);
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (103, 'CAES', 220.49, '- Pelagem bonita e pele saudável: rico em proteínas de alta qualidade e equilíbrio ideal de ácidos graxos essenciais - ômegas 3 e 6;', 'Ração Royal Canin para Cães Adultos da Raça Shih Tzu', 'https://www.petlove.com.br/images/products/212521/product/Ra%C3%A7%C3%A3o_Royal_Canin_para_C%C3%A3es_Adultos_da_Ra%C3%A7a_Shih_Tzu_31010302.jpg?1627682475', 7.5, 6, 'ATIVO', 323.90, 200);
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (104, 'CAES', 220.49, '- Ômega 3 e 6: Garantia de pele, pelos e articulações saudáveis;', 'Ração Fórmula Natural Life Super Premium para Cães Adultos Raças Mini e Pequena', 'https://www.petlove.com.br/images/products/243631/product/1_3107895_Ra%C3%A7%C3%A3o-F%C3%B3rmula-Natural-Super-Premium-para-C%C3%A3es-Adultos-Ra%C3%A7as-Mini-e-Pequena.jpg?1628875695', 15, 15, 'ATIVO', 248.90, 300);
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (105, 'GATOS', 170.49, '- Alimento totalmente adequada e indicada para gatos adultos;', 'Ração Fórmula Natural Life Sabor Frango para Gatos Adultos Castrados', 'https://www.petlove.com.br/images/products/243768/product/1_3107913_Ra%C3%A7%C3%A3o_F%C3%B3rmula_Natural_para_Gatos_Castrados.jpg?1628876773', 15, 15, 'ATIVO', 202.90, 300);
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (106, 'CAES', 220.49, '- Pelagem bonita e pele saudável: rico em proteínas de alta qualidade e equilíbrio ideal de ácidos graxos essenciais - ômegas 3 e 6;', 'Ração Premier Pet Ambientes Internos Cães Filhotes Frango e Salmão', 'https://www.petlove.com.br/images/products/261768/product/Ra%C3%A7%C3%A3o_Premier_Pet_Ambientes_Internos_C%C3%A3es_Filhotes_Frango_e_Salm%C3%A3o_-_12_Kg_3108262-3.jpg?1662044527', 10, 5, 'ATIVO', 250.99, 100);
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (107, 'CAES', 285.21, '- Alimento rico em nutrientes, promove a pelagem bonita e pele saudável;
- Combinação de ingredientes de alta digestibilidade, fibras especiais e prebiótico;', 'Ração Premier Pet Formula Cães Adultos Raças Pequenas', 'https://www.petlove.com.br/images/products/261741/product/Ra%C3%A7%C3%A3o_Premier_Pet_Formula_C%C3%A3es_Adultos_Ra%C3%A7as_Pequenas_-_20_Kg_3108224-3_4.jpg?1662042965', 20, 10, 'ATIVO', 285.21, 100);
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (108, 'GATOS', 119.49, '- Sabor inigualável: promove máxima satisfação para paladares exigentes;', 'Ração Seca PremieR Pet Golden Salmão para Gatos Adultos Castrados', 'https://www.petlove.com.br/images/products/261684/product/Ra%C3%A7%C3%A3o_Seca_PremieR_Pet_Golden_Salm%C3%A3o_para_Gatos_Adultos_Castrados_-_10_1_Kg_31022435-3_2.jpg?1662035152', 10, 5, 'ATIVO', 159.21, 100);
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (109, 'CAES', 220.49, '- Pelagem bonita e pele saudável: rico em proteínas de alta qualidade e equilíbrio ideal de ácidos graxos essenciais - ômegas 3 e 6;', 'Ração Royal Canin para Cães Adultos da Raça Shih Tzu', 'https://www.petlove.com.br/images/products/212521/product/Ra%C3%A7%C3%A3o_Royal_Canin_para_C%C3%A3es_Adultos_da_Ra%C3%A7a_Shih_Tzu_31010302.jpg?1627682475', 7.5, 6, 'ATIVO', 323.90, 200);
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (110, 'CAES', 220.49, '- Ômega 3 e 6: Garantia de pele, pelos e articulações saudáveis;', 'Ração Fórmula Natural Life Super Premium para Cães Adultos Raças Mini e Pequena', 'https://www.petlove.com.br/images/products/243631/product/1_3107895_Ra%C3%A7%C3%A3o-F%C3%B3rmula-Natural-Super-Premium-para-C%C3%A3es-Adultos-Ra%C3%A7as-Mini-e-Pequena.jpg?1628875695', 15, 15, 'ATIVO', 248.90, 300);
INSERT INTO public.produtos(
	id, categoria, custo, descricao, nome, nomeimagem, peso, quantidadeestoque, status, valorvenda, id_marca)
	VALUES (111, 'GATOS', 170.49, '- Alimento totalmente adequada e indicada para gatos adultos;', 'Ração Fórmula Natural Life Sabor Frango para Gatos Adultos Castrados', 'https://www.petlove.com.br/images/products/243768/product/1_3107913_Ra%C3%A7%C3%A3o_F%C3%B3rmula_Natural_para_Gatos_Castrados.jpg?1628876773', 15, 15, 'ATIVO', 202.90, 300);

