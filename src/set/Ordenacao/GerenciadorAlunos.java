package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Collections.addAll;

public class GerenciadorAlunos {
    //atributos

    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }
    public void adicionarAluno(String nome, long matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula){
        Aluno alunosParaRemover = null;
        for(Aluno a : alunoSet) {
            if(a.getMatricula() == matricula){
                alunosParaRemover = a;
                break;
            }
        }
        alunoSet.remove(alunosParaRemover);
    }
    public void exibirAlunos(){
        System.out.println(alunoSet);
    }
    public void exibirAlunosPorNome(){
        Set<Aluno> exibirPorNome = new TreeSet<>(alunoSet);
        System.out.println(exibirPorNome);
    }
    public void exibirAlunosPorNota(){
        Set<Aluno> exibirPorNota = new TreeSet<>(new ComparatorPorNota());
        exibirPorNota.addAll(alunoSet);
        System.out.println(exibirPorNota);
    }
    public static void main(String[] args) {
        // Criando uma instância do GerenciadorAlunos
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        // Adicionando alunos ao gerenciador
        gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
        gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
        gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
        gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);

        // Exibindo todos os alunos no gerenciador
        System.out.println("Alunos no gerenciador:");
        System.out.println(gerenciadorAlunos.alunoSet);

        // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
        gerenciadorAlunos.removerAluno(000L);
        gerenciadorAlunos.removerAluno(123457L);
        System.out.println("Após remoção");
        System.out.println(gerenciadorAlunos.alunoSet);

        // Exibindo alunos ordenados por nome
        gerenciadorAlunos.exibirAlunosPorNome();

        // Exibindo alunos ordenados por nota
        gerenciadorAlunos.exibirAlunosPorNota();
    }

}
