# Arrays

Arrays ou Vetores são uma estrutura de dados linear, onde os seus elementos estão dispostos 
de modo contíguo na memória. 

Existem três características importantes que definem essa estrutura de dados:

1. São homogêneos, ou seja, podem conter qualquer tipo de dado, mas desde que todos os elementos sejam do mesmo tipo;
2. São estruturas de tamanho fixo, isso quer dizer que uma vez definido o seu tamanho, ele não pode ser modificado;
3. São estruturas indexadas, cada elemento dentro do Array ocupa uma posição que será identificada por um índice;

## Arrays Dinâmicos

É um tipo especial de Array que além de herdar todas as características e funcionalidades de um Array normal,
estende a possibilidade do Array crescer o seu tamanho em tempo de execução.

Arrays dinâmicos possuem alguns atributos que o definem:
- data: o array que irá conter os elementos;
- capacidade(capacity): tamanho real do Array, ou seja, quantos elementos cabem no Array;
- tamanho(size): a quantidade atual de elementos presentes no Array;

### Funcionalides principais de um Array Dinâmico

- get(index): buscar um elemento pelo índice;
- set(index, valor): guardar um valor numa determinada posição do Array;
- insert(index, valor): adicionar um novo valor no Array e numa determinada posição;
- delete(index): deletar um valor presente no Array pelo seu índice;
- isEmpty(): verifica se o array não possui nenhum elemento;
- contais(valor): verifica se um determinado valor existe dentro do Array;
- resize(): aumenta o tamanho do Array criando um Array com um tamanho maior;
- getSize(): retorna a quantidade de elementos presentes no Array;
- getCapacity(): retorna a quantidade de elementos que cabem dentro do Array;

### Vantagem do Array

A principal vantagem do Array é a sua capacidade de buscar e guardar um valor em tempo constante.
Isso ocorre pois os Arrys são estruturas indexadas, e passando diretamento o indíce, é possível realizar
essas operações em tempo constante;