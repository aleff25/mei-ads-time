
# **ISCTE - ADS - Aplicação Horário**



Paara rodar a aplicação:

**Tenha instalado em sua máquina o docker;**

Execute o arquivo docker-compose.yml localizado na pasta `./source`
Rodando o comando: `docker-compose up` ou para ativar a função detach: `docker-compose up -d`

A primeira execução pode demorar alguns minutos dependendo da latencia e também da sua máquina


Após a execução acesse a url: *localhost:4200* para acessar a aplicação web

Já na tela inicial:

    - Schedule: Lista todos os agendamentos cadastrados na aplicação;
    - Create new appointment: Cria um novo agendamento;
    - Import new appointments (XLSX): Carrega um arquivo com os agendamentos dos horários.
        Ao carregar o arquivo .xlsx a aplicação importará todos os horários com agendamentos.
    
> Selecione um arquivo de exemplo em ./source/ADS - Exemplo horario.xlsx para uma importação rápida dos agendamentos.

### **Para acessar o banco de dados em memória basta acessar a url**:

>`localhost:8080/h2`

E no campo de JDBC URL colocar: `jdbc:h2:mem:testdb`


E clicar em **connect**

### **Desenho da arquitetura**

Link miro `https://miro.com/app/board/uXjVP_C6eao=/`

Aplicação baseada em serviços, utilizando padrão SOLID e DDD para desenho da
arquitetura da aplicaçao. Separando os business model.