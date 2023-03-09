package com.br.actionsitesale.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailConstantUtils {

    public static final String TITULO_CONTA_CRIADA = "Criação de conta - Banco KOL";

    public static final String CONTA_CRIADA = "Prezado Cliente, agradecemos a preferência e ficamos feliz em saber," +
            " que realizou a abertura de sua conta em uma de nossas agências.\n" +
            "Aproveite todas as vantagens, como investimentos, seguros e poupanças.\n" +
            "\n" + "Para qualquer alteração procure diretamente sua gerência.\n" +
            "\n" + "Atenciosamente equipe Banco KOL";

    public static final String TITULO_ALTERACAO_CONTA = "Alteração de dados - Banco KOL";

    public static final String ALTERACAO_REALIZADA = "Prezado Cliente, informamos que foi realizada a alteração solicitada," +
            "caso queira realizar a conferência, poderá verificar efetuando o login através do aplicativo.\n" +
            "Em caso de uma nova alteração, será realizada uma verificação prévia das informações.\n" +
            "Aproveitamos para alertar em relação as ofertas dentro do app bancário.\n" +
            "Atenciosamente equipe Banco KOL";

    public static final String TITULO_CANCELAMENTO_CONTA = "Cancelamento de conta - Banco KOL";

    public static final String CANCELAMENTO_REALIZADO = "Prezado Cliente, informamos que foi realizada o cancelamento solicitado," +
            "caso queira reabrir novamente sua conta bancária, favor compareça a agência mais próxima de sua residência.\n" +
            "Se preferir, também realize a abertura através de nosso site ou aplicativo.\n" +
            "Atenciosamente equipe Banco KOL";
}
