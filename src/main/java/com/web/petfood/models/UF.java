package com.web.petfood.models;

public enum UF {

    Acre_AC("Acre-AC"),
    Alagoas_AL("Alagoas - AL"),
    Amapa_AP("Amapá - AP"),
    Amazonas_AM("Amazonas - AM"),
    Bahia_BA("Bahia - BA"),
    Ceara_CE("Ceará - CE"),
    EspiritoSanto_ES("Espírito Santo - ES"),
    Goias_GO("Goiás - GO"),
    Maranhao_MA("Maranhão - MA"),
    MatoGrosso_MT("MatoGrosso - MT"),
    MatoGrossoDoSul_MS("Mato Grosso Do Sul - MS"),
    MinasGerais_MG("Minas Gerais - MG"),
    Para_PA("Pará - PA"),
    Paraiba_PB("Paraíba - PB"),
    Parana_PR("Paraná - PR"),
    Pernambuco_PE("Pernambuco - PE"),
    Piaui_PI("Piauí - PI"),
    RioDeJaneiro_RJ("Rio De Janeiro - RJ"),
    RioGrandeDoNorte_RN("Rio Grande Do Norte - RN"),
    RioGrandeDoSul_RS("Rio Grande Do Sul - RS"),
    Rondonia_RO("Rondônia - RO"),
    Roraima_RR("Roraima - RR"),
    SantaCatarina_SC("Santa Catarina - SC"),
    SaoPaulo_SP("São Paulo - SP"),
    Sergipe_SE("Sergipe - SE"),
    Tocantins_TO("Tocantins - TO"),
    DistritoFederal_DF("Distrito Federal - DF");

    private String descricao;

    private UF(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
