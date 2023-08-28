class Formacao(
    val nome: String,
    val nivel: String,
    val conteudosEducacionais: List<ConteudoEducacional>
) {
    private val matriculas: MutableList<Matricula> = mutableListOf()

    fun matricularAluno(aluno: Aluno) {
        val matricula = Matricula(aluno, this)
        matriculas.add(matricula)
    }

    fun listarMatriculas(): List<Matricula> {
        return matriculas.toList()
    }

    fun listarAlunosMatriculados(): List<Aluno> {
        return matriculas.map { it.aluno }
    }
}

class Aluno(val nome: String)

class ConteudoEducacional(val nome: String)

class Matricula(val aluno: Aluno, val formacao: Formacao)

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin")
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin")
    
    val formacao = Formacao("Formação de Desenvolvimento em Kotlin", "Avançado", listOf(conteudo1, conteudo2))
    
    val aluno1 = Aluno("Zé da manga")
    val aluno2 = Aluno("Sergin Cambalhota")
    
    formacao.matricularAluno(aluno1)
    formacao.matricularAluno(aluno2)
    
    println("Informações da Formação:")
    println("Nome: ${formacao.nome}")
    println("Nível: ${formacao.nivel}")
    
    println("Conteúdos Educacionais:")
    formacao.conteudosEducacionais.forEach { conteudo ->
        println("- ${conteudo.nome}")
    }
    
    println("Alunos matriculados na formação ${formacao.nome}:")
    formacao.listarAlunosMatriculados().forEachIndexed { index, aluno ->
        println("${index + 1}. Aluno: ${aluno.nome}")
    }
}
