package com.example.app_fichas_rpg;

public class Ficha {

    //region Atributos
    public String nome ="";
    public String classe="";
    public String raca="";
    public int nivel = 0;
    public double vidaTotal=0.0;
    public double vidaAtual=0.0;
    public double dano=0.0;

    public int forca=0;
    public int forcaExtra=0;

    public int inteligencia=0;
    public int inteligenciaExtra=0;

    public int agilidade=0;
    public int agilidadeExtra=0;


    public int desvio=0;
    public int desvioExtra=0;

    public int defesa=0;
    public int defesaExtra=0;

    public int deslocamento=0;
    public int deslocamentoExtra=0;


    public int conhecimento=0;
    public int conhecimentoExtra=0;

    public int carisma=0;
    public int carismaExtra=0;

    public int precisao=0;
    public int precisaoExtra=0;

    public int percepcao=0;
    public int percepcaoExtra=0;

    public int sorte=0;
    public int sorteExtra=0;

    public int furtividade=0;
    public int furtividadeExtra=0;
    //endregion

    //region Construtor vazio
    public Ficha(){}
    //endregion
    //region Construtor sem atributos extras
    public Ficha(String nome, String classe, String raca, double vidaTotal, double vidaAtual, double dano, int forca, int inteligencia, int agilidade, int desvio, int defesa, int deslocamento, int conhecimento, int carisma, int precisao, int percepcao, int sorte, int furtividade) {
        this.nome = nome;
        this.classe = classe;
        this.raca = raca;
        this.vidaTotal = vidaTotal;
        this.vidaAtual = vidaAtual;
        this.dano = dano;
        this.forca = forca;
        this.inteligencia = inteligencia;
        this.agilidade = agilidade;
        this.desvio = desvio;
        this.defesa = defesa;
        this.deslocamento = deslocamento;
        this.conhecimento = conhecimento;
        this.carisma = carisma;
        this.precisao = precisao;
        this.percepcao = percepcao;
        this.sorte = sorte;
        this.furtividade = furtividade;
    }
    //endregion
    //region Construtor com todos os atributos
    public Ficha(String nome, String classe, String raca, double vidaTotal, double vidaAtual, double dano, int forca, int forcaExtra, int inteligencia, int inteligenciaExtra, int agilidade, int agilidadeExtra, int desvio, int desvioExtra, int defesa, int defesaExtra, int deslocamento, int deslocamentoExtra, int conhecimento, int conhecimentoExtra, int carisma, int carismaExtra, int precisao, int precisaoExtra, int percepcao, int percepcaoExtra, int sorte, int sorteExtra, int furtividade, int furtividadeExtra) {
        this.nome = nome;
        this.classe = classe;
        this.raca = raca;
        this.vidaTotal = vidaTotal;
        this.vidaAtual = vidaAtual;
        this.dano = dano;
        this.forca = forca;
        this.forcaExtra = forcaExtra;
        this.inteligencia = inteligencia;
        this.inteligenciaExtra = inteligenciaExtra;
        this.agilidade = agilidade;
        this.agilidadeExtra = agilidadeExtra;
        this.desvio = desvio;
        this.desvioExtra = desvioExtra;
        this.defesa = defesa;
        this.defesaExtra = defesaExtra;
        this.deslocamento = deslocamento;
        this.deslocamentoExtra = deslocamentoExtra;
        this.conhecimento = conhecimento;
        this.conhecimentoExtra = conhecimentoExtra;
        this.carisma = carisma;
        this.carismaExtra = carismaExtra;
        this.precisao = precisao;
        this.precisaoExtra = precisaoExtra;
        this.percepcao = percepcao;
        this.percepcaoExtra = percepcaoExtra;
        this.sorte = sorte;
        this.sorteExtra = sorteExtra;
        this.furtividade = furtividade;
        this.furtividadeExtra = furtividadeExtra;
    }
    //endregion

    //region Getters
    public String getNome() {return nome;   }

    public String getClasse() {return classe;    }

    public int getNivel(){return nivel;}

    public String getRaca() {return raca;    }

    public double getVidaTotal() {return vidaTotal;    }

    public double getVidaAtual() {return vidaAtual;    }

    public double getDano() {return dano;    }

    public int getForca() {return forca;    }

    public int getForcaExtra() {return forcaExtra;    }

    public int getInteligencia() {return inteligencia;    }

    public int getInteligenciaExtra() {return inteligenciaExtra;    }

    public int getAgilidade() {return agilidade;    }

    public int getAgilidadeExtra() {return agilidadeExtra;    }

    public int getDesvio() {return desvio;    }

    public int getDesvioExtra() {return desvioExtra;    }

    public int getDefesa() {return defesa;    }

    public int getDefesaExtra() {return defesaExtra;    }

    public int getDeslocamento() {return deslocamento;    }

    public int getDeslocamentoExtra() {return deslocamentoExtra;    }

    public int getConhecimento() {return conhecimento;    }

    public int getConhecimentoExtra() {return conhecimentoExtra;    }

    public int getCarisma() {return carisma;    }

    public int getCarismaExtra() {return carismaExtra;    }

    public int getPrecisao() {return precisao;}

    public int getPrecisaoExtra() {return precisaoExtra;}

    public int getPercepcao() {return percepcao;}

    public int getPercepcaoExtra() {return percepcaoExtra;}

    public int getSorte() {return sorte;}

    public int getSorteExtra() {return sorteExtra;}

    public int getFurtividade() {return furtividade;}

    public int getFurtividadeExtra() {return furtividadeExtra;}
    //endregion
    //region Setters
    public void setNome(String nome) {this.nome = nome;}

    public void setClasse(String classe) {this.classe = classe;}

    public void setRaca(String raca) {this.raca = raca;}

    public void setNivel(int nivel){this.nivel = nivel;}

    public void setVidaTotal(double vidaTotal) {this.vidaTotal = vidaTotal;}

    public void setVidaAtual(double vidaAtual) {this.vidaAtual = vidaAtual; }

    public void setDano(double dano) {this.dano = dano; }

    public void setForca(int forca) {this.forca = forca;}

    public void setForcaExtra(int forcaExtra) {this.forcaExtra = forcaExtra; }

    public void setInteligencia(int inteligencia) {this.inteligencia = inteligencia;}

    public void setInteligenciaExtra(int inteligenciaExtra) {this.inteligenciaExtra = inteligenciaExtra;}

    public void setAgilidade(int agilidade) {this.agilidade = agilidade; }

    public void setAgilidadeExtra(int agilidadeExtra) {this.agilidadeExtra = agilidadeExtra; }

    public void setDesvio(int desvio) {this.desvio = desvio;}

    public void setDesvioExtra(int desvioExtra) {this.desvioExtra = desvioExtra;}

    public void setDefesa(int defesa) {this.defesa = defesa;}

    public void setDefesaExtra(int defesaExtra) {this.defesaExtra = defesaExtra;}

    public void setDeslocamento(int deslocamento) {this.deslocamento = deslocamento; }

    public void setDeslocamentoExtra(int deslocamentoExtra) {this.deslocamentoExtra = deslocamentoExtra;}

    public void setConhecimento(int conhecimento) {this.conhecimento = conhecimento;}

    public void setConhecimentoExtra(int conhecimentoExtra) {this.conhecimentoExtra = conhecimentoExtra;}

    public void setCarisma(int carisma) {this.carisma = carisma;}

    public void setCarismaExtra(int carismaExtra) {this.carismaExtra = carismaExtra;}

    public void setPrecisao(int precisao) {this.precisao = precisao;}

    public void setPrecisaoExtra(int precisaoExtra) {this.precisaoExtra = precisaoExtra;}

    public void setPercepcao(int percepcao) {this.percepcao = percepcao;}

    public void setPercepcaoExtra(int percepcaoExtra) {this.percepcaoExtra = percepcaoExtra;}

    public void setSorte(int sorte) {this.sorte = sorte;}

    public void setSorteExtra(int sorteExtra) {this.sorteExtra = sorteExtra;}

    public void setFurtividade(int furtividade) {this.furtividade = furtividade; }

    public void setFurtividadeExtra(int furtividadeExtra) {this.furtividadeExtra = furtividadeExtra;}
    //endregion

}
