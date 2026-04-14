import exercicios.Cidade;
import exercicios.CidadeRecord;
import exercicios.PessoaRecord;
import exercicios.PessoaRecordShallow;

/**
 * Classe para você testar suas implementações.
 * Veja o README para mais detalhes.
 */
public class Principal {
    public static void main(final String[] args) {
        CidadeRecord cidadeRecord = new CidadeRecord("Palmas"); // cidadeRecord é Imutável
        System.out.println("CidadeRecord: " + cidadeRecord.nome());
        //cidadeRecord.nome = "Paraíso";    // Gera erro de compilação, pois nome é imutável:
                                            // java: nome has private access in exercicios.CidadeRecord

        System.out.println("\n ***************** \n");

        Cidade cidade = new Cidade("Palmas"); // cidade é mutável
        System.out.println("Cidade: " + cidade.getNome());
        cidade.setNome("Paraíso");
        System.out.println("Cidade alterada: " + cidade.getNome()); // Não gera erro de compilação, portanto é mutável pq pode ser alterada

        System.out.println("\n ***************** \n");

        PessoaRecordShallow pessoaShallow = new PessoaRecordShallow("João", cidade); // pessoaShallow é superficialmente imutável
        System.out.println("PessoaShallow nome inicial: " + pessoaShallow.nome());
        System.out.println("PessoaShallow cidade inicial: " + pessoaShallow.cidade().getNome());
        pessoaShallow.cidade().setNome("Porto Nacional"); // Não gera erro, pois o nome da cidade é mutável em pessoaShallow
        //pessoaShallow.nome = "José";  // Gera erro de compilação, pois nome é imutável em pessoaShallow:
                                        // java: nome has private access in exercicios.PessoaRecordShallow
        System.out.println("PessoaShallow nome final: " + pessoaShallow.nome());
        System.out.println("PessoaShallow cidade final: " + pessoaShallow.cidade().getNome());

        System.out.println("\n ***************** \n");

        PessoaRecord pessoaRecord = new PessoaRecord("Maria", cidadeRecord); // pessoaRecord é profundamente imutável
        System.out.println("PessoaRecord nome inicial: " + pessoaRecord.nome());
        System.out.println("PessoaRecord cidade inicial: " + pessoaRecord.cidade().nome());
        //pessoaRecord.nome = "Ana";                 // Gera erro de compilação, pois nome é imutável em pessoaRecord
                                                     // java: nome has private access in exercicios.PessoaRecord
        //pessoaRecord.cidade().nome = "Taquaralto"; // Também gera o mesmo erro de compilação acima

        System.out.println("\n ***************** \n");

        System.out.println("Resumo dos testes (sem erros de compilação e com todos os testes bem sucedidos):");
        System.out.println("\t- cidadeRecord é imutável (não pode ser alterada)");
        System.out.println("\t- cidade é mutável (pode ser alterada)");
        System.out.println("\t- pessoaShallow é superficialmente imutável (nome não pode ser alterado, mas cidade pode)");
        System.out.println("\t- pessoaRecord é profundamente imutável (nome e cidade não podem ser alterados)");
    }
}
