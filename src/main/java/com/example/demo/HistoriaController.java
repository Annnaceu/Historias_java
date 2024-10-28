package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class HistoriaController {

    private HashMap<String, Historia> historias = new HashMap<>();

    public HistoriaController() {
        Historia misterio = new Historia("Era uma noite escura e tempestuosa. A chuva caía com força, fazendo o som das gotas ecoar pela cidade deserta. O vento assobiava entre as árvores, criando uma atmosfera de tensão. De repente, uma luz estranha cortou o céu, revelando uma figura enigmática.", 
            "E então um disco voador apareceu, sugando tudo ao seu redor e levando as pessoas para longe de casa. Você conseguiu escapar e se escondeu, mas a pergunta permanece: o que acontece agora?");
        misterio.adicionarEscolha("Investigar a casa, onde a luz foi vista pela última vez.");
        misterio.adicionarEscolha("Chamar a polícia e relatar o que viu.");
        misterio.adicionarEscolha("Ignorar e continuar sua caminhada, como se nada tivesse acontecido.");
        
        historias.put("Mistério", misterio);

        Historia aventura = new Historia("Em uma terra distante, um jovem herói chamado Eldrin se preparava para uma jornada épica. Ele estava determinado a encontrar o lendário artefato que prometia trazer paz ao seu reino, mas sabia que a estrada seria cheia de desafios e criaturas míticas.", 
            "Após enfrentar muitos perigos e forjar amizades ao longo do caminho, Eldrin percebeu que o verdadeiro tesouro não era o artefato em si, mas as lições e laços que formou durante sua jornada.");
        aventura.adicionarEscolha("Explorar a floresta densa que guarda muitos segredos.");
        aventura.adicionarEscolha("Buscar aliados na aldeia próxima, fortalecendo sua equipe.");
        aventura.adicionarEscolha("Retornar para casa e deixar a aventura para outra ocasião.");
        
        historias.put("Aventura", aventura);
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("temas", historias.keySet());
        return "index";
    }

    @PostMapping("/selecionarTema")
    public String selecionarTema(@RequestParam String tema, Model model) {
        Historia historia = historias.get(tema);
        if (historia == null) {
            model.addAttribute("resultado", "Tema inválido!");
            return "index";
        }
        model.addAttribute("introducao", historia.getIntroducao());
        model.addAttribute("opcoes", historia.getEscolhas());
        model.addAttribute("tema", tema);
        return "resultado";
    }

    @PostMapping("/gerar")
    public String gerarHistoria(@RequestParam String tema, 
                                @RequestParam String escolha, 
                                Model model) {
        Historia historia = historias.get(tema);
        String resultado = historia.getFinalHistoria();
        
        model.addAttribute("resultado", historia.getIntroducao() + " " + resultado);
        model.addAttribute("temas", historias.keySet());
        return "resultado";
    }
}











