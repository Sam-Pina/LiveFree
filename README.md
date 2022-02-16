# Grupo 5 - Tarefa 2 do PI - Prototipando o Banco de dados
Desenvolvedores:
-   Aline Dias;
-   Caique Ramos;    
-   Guilherme Petry;    
-   Marco Alexandre;    
-   Raiza de Paula;    
-   Samuel Santos;    
-   Vanessa de Azevedo.

### Tabela 1: tb_usuarios
Motivo: Esta tabela foi criada para armazenar dados dos cadastros de 2 tipos de usuários: profissionais e clientes. Dados como nome, e-mail, telefone/celular, senha, cidade e idioma, inseridos pelo usuário (seja do tipo profissional ou do tipo cliente) no momento do cadastro, serão armazenados nesta tabela. Nosso serviço precisa desses dados para conectar prestadores de serviços com pacientes (clientes).

tb_usuario (
id_usuario INT AUTO_INCREMENT NOT NULL,
nome VARCHAR(200) NOT NULL,
email VARCHAR(200) NOT NULL,
telefone/cel VARCHAR(25) NOT NULL,
senha VARCHAR(200) NOT NULL,
tipo_de_usuario ENUM('CLIENTE','PROFISSIONAL')
cidade VARCHAR(200) NOT NULL,
idioma VARCHAR(45)
PRIMARY KEY (id)
);

### Tabela 2: tb_categoria
Motivo: Esta tabela foi criada para armazenar os dados referentes às categorias dos serviços prestados (podem ser terapia, remédio, assistência social e clínica), às modalidades de atendimento (podem ser presencial ou online) e aos motivos do contato (podem ser: alcoolismo, vício em drogas, doenças emocionais/mentais, necessidade de acompanhamento comportamental e nutricional, entre outros).

tb_servico(
id INT AUTO_INCREMENT NOT NULL,
descricao VARCHAR (2000) NOT NULL,
preco DECIMAL (4,2)
avaliacao/atendimento INT NOT NULL,*
foto_profissional VARCHAR(2000) NOT NULL,
fk_categoria INT
fk_usuario INT
PRIMARY KEY (id)
FOREIGN KEY (fk_usuario) REFERENCES tb_usuario (id_usuario),
FOREIGN KEY (fk_categoria) REFERENCES tb_categoria (id_categoria)
);

### Tabela 3: tb_servicos
Motivo: Esta tabela foi criada para armazenar os dados referentes aos serviços que os profissionais podem prestar. Esses são os dados que serão exibidos no anúncio de serviço de um profissional, ou seja: foto, nome, localização, disponibilidade e descrição do serviço prestado pelos profissionais. Além disso, essa tabela também recebe dois outros campos (através de chaves estrangeiras), são eles: id do usuário, da tabela tb_usuario e categoria do serviço, da tabela tb_categoria.

tb_categoria(
id_categoria INT AUTO_INCREMENT NOT NULL,
nome_categoria VARCHAR(200) NOT NULL,
-- pode ser: terapia ,remédio, assistência social e clínica.
modo_atend ENUM('PRESENCIAL','ONLINE'),
-- pode ser: presencial ou online.
motivo VARCHAR (45),
-- alcoolismo, vício em drogas, comportamental, doenças emocional/doenças mentais, nutricionista
PRIMARY KEY (id)
);
