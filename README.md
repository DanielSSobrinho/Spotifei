# Spotifei

Spotifei - Relatório do Projeto


1. Introdução
O projeto Spotifei foi uma aplicação desktop desenvolvida em Java, com interface gráfica criada no NetBeans, essa aplicação foi pensada no app Spotify. Seu objetivo é permitir a organização e visualização de playlists musicais, simulando uma experiência básica de um sistema de streaming. Entre suas funcionalidades principais, estão o login de usuários, criação e exclusão de playlists e visualização de músicas associadas.

2. Tecnologias Utilizadas
Java (JDK 17)
NetBeans IDE 18
PostgreSQL 15
Driver JDBC PostgreSQL
GitHub 

3. Funcionalidades Implementadas
a) Tela de Login
Permite autenticação dos usuários cadastrados.
Valida os dados no banco e redireciona para a tela principal.
Caso não possua cadastro, há um campo para realização.

b) Tela Principal (Menu)
Disponibiliza opções para:
Buscar músicas
Visualizar playlists
Curtir e Descurtir músicas
Visualizar histórico de buscas/curtidas/descurtidas

c) Playlists
Permite criar e excluir playlists associadas ao usuário logado.
É possível selecionar uma playlist para visualizar as músicas associadas.

d) Músicas da Playlist
Exibe todas as músicas vinculadas à playlist selecionada.
Dados mostrados: ID, título, artista e gênero.

e) Banco de Dados
Projeto usa banco PostgreSQL com as seguintes tabelas:
usuario
artista
musica
playlist
playlist_musica
curtidas
historico_busca
As tabelas estão ligadas por chaves estrangeiras.

4. Desenvolvimento
Estrutura MVC:
model: representa os dados (Usuario, Musica, Playlist)
dao: acessa o banco com JDBC (UsuarioDAO, MusicaDAO, PlaylistDAO)
controller: lógica de ações (ControllerLogin, ControllerMenu, etc.)
view: interfaces gráficas feitas no NetBeans
Utilização de DefaultTableModel para manipulção de tabelas.
Telas conectadas com passagem de parâmetros (ex: ID do usuário).

5. Javadoc
Gerado automaticamente pelo NetBeans.
Comentários nos arquivos de código descrevem classes e métodos.

6. Conclusão
O projeto Spotifei atendeu às expectativas de uma aplicação desktop funcional, com estrutura organizada e funcionalidades essenciais de um gerenciador de playlists. O uso de tecnologias consolidadas como Java, PostgreSQL e NetBeans permitiu o bom desenvolvimento do projeto, atendendo as requisições propostas. 
Aluno: Daniel Santos Sobrinho
