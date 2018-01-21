[![Build Status](https://travis-ci.org/edenir-anschau/cnab-caixa.svg?branch=master)](https://travis-ci.org/edenir-anschau/cnab-caixa)

# cnab-caixa
> Geração de Remessa de cobrança bancária no layout CNAB240 para Caixa Economica Federal

Documentação CNAB240: [Manual_Leiaute_CNAB240_SIGCB.pdf](http://www.caixa.gov.br/Downloads/cobranca-caixa/Manual_Leiaute_CNAB240_SIGCB.pdf)

**Obs.:** no momento gera somente a Remessa com os segmentos P e Q.

## Instalação

Adicionar no pom.xml:

```xml
<dependency>
  <groupId>net.anschau</groupId>
  <artifactId>cnab-caixa</artifactId>
  <version>1.0.0</version>
</dependency>

```
## Gerando uma remessa

```java
Beneficiario beneficiario = new Beneficiario("João da Silva", "1087", 1,  "123456", "86479743520");
    
Pagador pagador = new Pagador("Pagador PF", "65453512300", "Rua ABC, 123", "Centro", "12345678");
    
LocalDate emissao = LocalDate.of(2017, 10,02);
LocalDate vencimento = LocalDate.of(2017, 9, 29);
Titulo titulo = new Titulo(6.00d, emissao, vencimento, 3, 3, pagador);
List<Titulo> titulos = ImmutableList.of(titulo);

int numeroRemessa = 1;
LocalDateTime dataHoraGeracao = LocalDateTime.of(2017, 10, 2, 8, 9, 44);
LocalDate dataGravacao = LocalDate.of(2017, 10, 2);
Remessa remessa = new Remessa(numeroRemessa, beneficiario, titulos, dataHoraGeracao, dataGravacao);

String remessaGerada = remessa.gerarArquivo();
```

```remessaGerada``` contém o conteúdo da Remessa gerada:

```
10400000         1000864797435200000000000000000000001087112345600000000JOAO DA SILVA                 CAIXA ECONOMICA FEDERAL                 10210201708094400000105000000                    REMESSA-PRODUCAO                                 
10400011R0100030 10000864797435201234560000000000000001087112345600000000JOAO DA SILVA                                                                                                 000000010210201700000000                                 
1040001300001P 010108711234560000000000014000000000000003112203              2909201700000000000060000000019N021020173000000000000000000000000000000000000000000000000000000000000000000000000000003                        3001005090000000000 
1040001300002Q 011000065453512300PAGADOR PF                              RUA ABC, 123                            CENTRO         12345678SAO PAULO      SP0000000000000000                                                                       
10400015         000004000000000000000000000000000000000000000000000000000000000000000000000                                                                                                                                                    
10499999         000001000006                                                                                                                                                                                                                   
```


## Validando a remessa gerada

[Aplicativo Validador de Arquivos Remessa disponibilizado pela Caixa](http://www.caixa.gov.br/Downloads/cobranca-caixa/Validador_de_Arquivos_Remessa.zip)

Além da validação do layout, é necessário fazer a homologação com a Caixa.

Mais detalhes sobre a obrigatoriedade de registrar boletos: http://www.caixa.gov.br/empresa/pagamentos-recebimentos/recebimentos/nova-cobranca-bancaria/Paginas/default.aspx
