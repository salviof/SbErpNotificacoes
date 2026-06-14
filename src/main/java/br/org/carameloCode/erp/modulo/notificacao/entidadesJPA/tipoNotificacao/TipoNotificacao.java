package br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.estrategiaNotificacao.FabTipoEstrategiaMidiaNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeORMNormal;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.ItfEntidadeExtensivel;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.ListenerEntidadePadrao;
import com.super_bits.modulosSB.SBCore.modulos.erp.FabTipoAgenteOrganizacao;
import com.super_bits.modulosSB.SBCore.modulos.geradorCodigo.model.EstruturaDeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoValidadorLogico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoValorLogico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoVerdadeiroOuFalso;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.InfoGrupoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.modeloDocumento.ComoModeloDocumento;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Tipo de Notificação"}, plural = "Tipos de Notificação", icone = "fa fa-bullhorn")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoEntidade")
@EntityListeners(ListenerEntidadePadrao.class)
public class TipoNotificacao extends EntidadeORMNormal implements ItfEntidadeExtensivel, ComoModeloDocumento {

    @Id
    @GenericGenerator(
            name = "geradorIdDuploControle",
            strategy = "com.super_bits.modulosSB.Persistencia.geradorDeId.GeradorIdDuploControleIncremental")
    @GeneratedValue(generator = "geradorIdDuploControle")
    private Long id;

    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoEntidade;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME, somenteLeitura = false)
    @InfoCampoValidadorLogico()
    @InfoCampoValorLogico(nomeCalculo = "Nome")
    private String nome;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    @Column(columnDefinition = "VARCHAR(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String assunto;

    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML_TEMPLATE)
    @Column(columnDefinition = "VARCHAR(8000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String conteudoHTML;

    @InfoCampo(label = "Gatilho de Notificação", descricao = "Solicita que o sistema ative a notificação, toda vez que a ação escolhida seja executada COM SUCESSO. Ex: Ao salvar um novo cliente, notifique o gerente",
            somenteLeitura = false,
            tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA,
            caminhoParaLista = "acaoesGatilhoDisponiveis"
    )
    @InfoCampoValidadorLogico()
    @InfoCampoValorLogico(nomeCalculo = "Ação gatilho notificação", somenteLeitura = false)
    @Transient
    private AcaoDoSistema acaoGatilhoNotificacao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String nomeFabricaGatilhoNoticao;

    @InfoCampo(label = "Gatilho após confirmação de envio da notificação", descricao = "Solicita que o sistema dispare outra notificação, assim que ouver um disparo SEM confirmação de entregua",
            somenteLeitura = false,
            caminhoParaLista = "acaoesGatilhoDisponiveis")
    @InfoCampoValorLogico(nomeCalculo = "Ação gatilho Disparo", somenteLeitura = false)
    @Transient
    private AcaoDoSistema acaoAutoExecucaoEnvio;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String nomeFabricaGatilhoAcaoEnviada;

    @InfoCampo(label = "Gatilho após confirmação de entrega", descricao = "Solicita que o sistema dispare outra notificação, assim que uma notificação tiver uma confirmação de ENTREGA (antes de ser lida)",
            somenteLeitura = false,
            caminhoParaLista = "acaoesGatilhoDisponiveis")
    @InfoCampoValorLogico(nomeCalculo = "Ação gatilho Entrega", somenteLeitura = false)
    @Transient
    private AcaoDoSistema acaoAutoExecucaoEntrega;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String nomeFabricaGatilhoAcaoEntrega;

    @InfoCampo(label = "Gatilho após confirmação de Leitura", descricao = "Solicita que o sistema dispare outra notificação, assim que uma notificação tiver uma confirmação de LEITURA",
            somenteLeitura = false,
            caminhoParaLista = "acaoesGatilhoDisponiveis")
    @InfoCampoValorLogico(nomeCalculo = "Ação gatilho Leitura", somenteLeitura = false)
    @Transient
    private AcaoDoSistema acaoAutoExecucaoLeitura;
    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String nomeFabricaGatilhoAcaoLeitura;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean exigirReciboDeEntrega;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean exigirReciboLeitura;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean notificacaoUnica = true;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO, label = "Via Matrix")
    @InfoCampoVerdadeiroOuFalso
    @InfoCampoValidadorLogico()
    private boolean notifificarViaMatrix = false;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO, label = "Via Intranet")
    @InfoCampoVerdadeiroOuFalso
    @InfoCampoValidadorLogico()
    private boolean notificarViaMenu = true;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO, label = "Via Tela Bloqueio")
    @InfoCampoVerdadeiroOuFalso
    @InfoCampoValidadorLogico()
    private boolean notificarViaTelaDeBLoqueio = false;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO, label = "Via APP")
    @InfoCampoVerdadeiroOuFalso
    @InfoCampoValidadorLogico()
    private boolean notificarViaMobile = false;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO, label = "Via Msg Whatsapp")
    @InfoCampoVerdadeiroOuFalso
    @InfoCampoValidadorLogico()
    private boolean notificarViaWhatsapp = false;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    @InfoCampoValidadorLogico()
    private boolean notificarViaApiPersonalizada = false;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    @InfoCampoValidadorLogico()
    private boolean notificarViaSMS = false;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    @InfoCampoValidadorLogico()
    private boolean notificarViaEmail = false;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean remetenteAguardaResposta = false;

    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE)
    private int minutosRenotificacao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE, valorMinimo = 1, valorMaximo = 30, label = "Dias Log", descricao = "Quantos dias o registro da notificação deve permanecer registrado, após a leitura do usuário")
    private int diasLog = 7;

    @InfoCampo(tipo = FabTipoAtributoObjeto.REG_ATIVO_INATIVO)
    @InfoCampoVerdadeiroOuFalso
    private boolean ativo = true;

    private String nomeEntidadeReferencia;

    @InfoCampo(label = "Origem usuário Destinatário", descricao = "Caminho relativo entidade vinculada para Usuario destinatario, ou para lista de usuários destinatarios ex: Orcamento.cliente.usuarioResonsável ou Orcamento.cliente.funcionarios[] *O nome da entidade não é obrigatŕio")
    @InfoCampoValidadorLogico()
    private String caminhoUsuarioDestinatario;

    @InfoCampo(tipo = FabTipoAtributoObjeto.ENUM_FABRICA, fabricaDeOpcoes = FabTipoAgenteOrganizacao.class)
    @Enumerated(EnumType.STRING)
    private FabTipoAgenteOrganizacao tipoAgente;

    @Transient
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, caminhoParaLista = "entidadesDisponiveis", entidadeOpcoesDisponiveis = EstruturaDeEntidade.class)
    @InfoGrupoCampo(camposDeclarados = {"icone", "nomeEntidade"})
    @InfoCampoValorLogico(nomeCalculo = "Entidade", somenteLeitura = false)
    @InfoCampoValidadorLogico()
    private EstruturaDeEntidade estruturaEntidade;

    @InfoCampo(tipo = FabTipoAtributoObjeto.LISTA_OBJETOS_PUBLICOS)
    @InfoCampoValorLogico(nomeCalculo = "Açoes disponiveis")
    @Transient
    private List<AcaoDoSistema> acaoesGatilhoDisponiveis;

    @InfoCampo(tipo = FabTipoAtributoObjeto.LISTA_OBJETOS_PUBLICOS)
    @InfoCampoValorLogico(nomeCalculo = "EStruturas disponiveis")
    @Transient
    private List<EstruturaDeEntidade> entidadesDisponiveis;

    @Enumerated(EnumType.STRING)
    private FabTipoEstrategiaMidiaNotificacao estrategia = FabTipoEstrategiaMidiaNotificacao.PROGRESSIVA;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso()
    private boolean tipoNotificacaoNativa = true;

    @Override
    public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
        tipoNotificacaoNativa = false;
    }

    public TipoNotificacaoUsrComUsr getComoTiponotificacaoUsrToUsr() {
        return (TipoNotificacaoUsrComUsr) this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(String tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudoHTML() {
        return conteudoHTML;
    }

    public void setConteudoHTML(String conteudoHTML) {
        this.conteudoHTML = conteudoHTML;
    }

    public AcaoDoSistema getAcaoGatilhoNotificacao() {
        return acaoGatilhoNotificacao;
    }

    public void setAcaoGatilhoNotificacao(AcaoDoSistema acaoGatilhoNotificacao) {
        this.acaoGatilhoNotificacao = acaoGatilhoNotificacao;
    }

    public boolean isNotificacaoUnica() {
        return notificacaoUnica;
    }

    public void setNotificacaoUnica(boolean notificacaoUnica) {
        this.notificacaoUnica = notificacaoUnica;
    }

    public boolean isNotifificarViaMatrix() {
        return notifificarViaMatrix;
    }

    public void setNotifificarViaMatrix(boolean notifificarViaMatrix) {
        this.notifificarViaMatrix = notifificarViaMatrix;
    }

    public boolean isNotificarViaMenu() {
        return notificarViaMenu;
    }

    public void setNotificarViaMenu(boolean notificarViaMenu) {
        this.notificarViaMenu = notificarViaMenu;
    }

    public boolean isNotificarViaTelaDeBLoqueio() {
        return notificarViaTelaDeBLoqueio;
    }

    public void setNotificarViaTelaDeBLoqueio(boolean notificarViaTelaDeBLoqueio) {
        this.notificarViaTelaDeBLoqueio = notificarViaTelaDeBLoqueio;
    }

    public boolean isNotificarViaMobile() {
        return notificarViaMobile;
    }

    public void setNotificarViaMobile(boolean notificarViaMobile) {
        this.notificarViaMobile = notificarViaMobile;
    }

    public boolean isNotificarViaWhatsapp() {
        return notificarViaWhatsapp;
    }

    public void setNotificarViaWhatsapp(boolean notificarViaWhatsapp) {
        this.notificarViaWhatsapp = notificarViaWhatsapp;
    }

    public boolean isNotificarViaSMS() {
        return notificarViaSMS;
    }

    public void setNotificarViaSMS(boolean notificarViaSMS) {
        this.notificarViaSMS = notificarViaSMS;
    }

    public boolean isNotificarViaEmail() {
        return notificarViaEmail;
    }

    public void setNotificarViaEmail(boolean notificarViaEmail) {
        this.notificarViaEmail = notificarViaEmail;
    }

    public int getMinutosRenotificacao() {
        return minutosRenotificacao;
    }

    public void setMinutosRenotificacao(int minutosRenotificacao) {
        this.minutosRenotificacao = minutosRenotificacao;

    }

    public int getDiasLog() {
        return diasLog;
    }

    public void setDiasLog(int diasLog) {
        this.diasLog = diasLog;
    }

    public boolean isNotificarViaApiPersonalizada() {
        return notificarViaApiPersonalizada;
    }

    public void setNotificarViaApiPersonalizada(boolean notificarViaApiPersonalizada) {
        this.notificarViaApiPersonalizada = notificarViaApiPersonalizada;
    }

    public AcaoDoSistema getAcaoAutoExecucaoEnvio() {
        return acaoAutoExecucaoEnvio;
    }

    public void setAcaoAutoExecucaoEnvio(AcaoDoSistema acaoAutoExecucaoEnvio) {
        this.acaoAutoExecucaoEnvio = acaoAutoExecucaoEnvio;
    }

    public boolean isExigirReciboDeEntrega() {
        return exigirReciboDeEntrega;
    }

    public void setExigirReciboDeEntrega(boolean exigirReciboDeEntrega) {
        this.exigirReciboDeEntrega = exigirReciboDeEntrega;
    }

    public boolean isExigirReciboLeitura() {
        return exigirReciboLeitura;
    }

    public void setExigirReciboLeitura(boolean exigirReciboLeitura) {
        this.exigirReciboLeitura = exigirReciboLeitura;
    }

    public AcaoDoSistema getAcaoAutoExecucaoEntrega() {
        return acaoAutoExecucaoEntrega;
    }

    public void setAcaoAutoExecucaoEntrega(AcaoDoSistema acaoAutoExecucaoEntrega) {
        this.acaoAutoExecucaoEntrega = acaoAutoExecucaoEntrega;
    }

    public AcaoDoSistema getAcaoAutoExecucaoLeitura() {
        return acaoAutoExecucaoLeitura;
    }

    public void setAcaoAutoExecucaoLeitura(AcaoDoSistema acaoAutoExecucaoLeitura) {
        this.acaoAutoExecucaoLeitura = acaoAutoExecucaoLeitura;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean isEntidadeExtendida() {
        return false;
    }

    public String getNomeEntidadeReferencia() {
        return nomeEntidadeReferencia;
    }

    public void setNomeEntidadeReferencia(String nomeEntidadeReferencia) {
        this.nomeEntidadeReferencia = nomeEntidadeReferencia;
    }

    public EstruturaDeEntidade getEstruturaEntidade() {
        return estruturaEntidade;
    }

    public void setEstruturaEntidade(EstruturaDeEntidade estruturaEntidade) {
        this.estruturaEntidade = estruturaEntidade;
    }

    public List<EstruturaDeEntidade> getEntidadesDisponiveis() {
        return entidadesDisponiveis;
    }

    public void setEntidadesDisponiveis(List<EstruturaDeEntidade> entidadesDisponiveis) {
        this.entidadesDisponiveis = entidadesDisponiveis;
    }

    @Override
    public String getEntidadePrincipalPalavraChave() {
        return nomeEntidadeReferencia;
    }

    public boolean isRemetenteAguardaResposta() {
        return remetenteAguardaResposta;
    }

    public void setRemetenteAguardaResposta(boolean remetenteAguardaResposta) {
        this.remetenteAguardaResposta = remetenteAguardaResposta;
    }

    public FabTipoAgenteOrganizacao getTipoAgente() {
        return tipoAgente;
    }

    public void setTipoAgente(FabTipoAgenteOrganizacao tipoAgente) {
        this.tipoAgente = tipoAgente;
    }

    public FabTipoEstrategiaMidiaNotificacao getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(FabTipoEstrategiaMidiaNotificacao estrategia) {
        this.estrategia = estrategia;
    }

    public boolean isTipoNotificacaoNativa() {
        return tipoNotificacaoNativa;
    }

    public void setTipoNotificacaoNativa(boolean tipoNotificacaoNativa) {
        this.tipoNotificacaoNativa = tipoNotificacaoNativa;
    }

    public List<AcaoDoSistema> getAcaoesGatilhoDisponiveis() {
        return acaoesGatilhoDisponiveis;
    }

    public void setAcaoesGatilhoDisponiveis(List<AcaoDoSistema> acaoesGatilhoDisponiveis) {
        this.acaoesGatilhoDisponiveis = acaoesGatilhoDisponiveis;
    }

    public String getNomeFabricaGatilhoNoticao() {
        return nomeFabricaGatilhoNoticao;
    }

    public void setNomeFabricaGatilhoNoticao(String nomeFabricaGatilhoNoticao) {
        this.nomeFabricaGatilhoNoticao = nomeFabricaGatilhoNoticao;
    }

    public String getNomeFabricaGatilhoAcaoEnviada() {
        return nomeFabricaGatilhoAcaoEnviada;
    }

    public void setNomeFabricaGatilhoAcaoEnviada(String nomeFabricaGatilhoAcaoEnviada) {
        this.nomeFabricaGatilhoAcaoEnviada = nomeFabricaGatilhoAcaoEnviada;
    }

    public String getNomeFabricaGatilhoAcaoEntrega() {
        return nomeFabricaGatilhoAcaoEntrega;
    }

    public void setNomeFabricaGatilhoAcaoEntrega(String nomeFabricaGatilhoAcaoEntrega) {
        this.nomeFabricaGatilhoAcaoEntrega = nomeFabricaGatilhoAcaoEntrega;
    }

    public String getNomeFabricaGatilhoAcaoLeitura() {
        return nomeFabricaGatilhoAcaoLeitura;
    }

    public void setNomeFabricaGatilhoAcaoLeitura(String nomeFabricaGatilhoAcaoLeitura) {
        this.nomeFabricaGatilhoAcaoLeitura = nomeFabricaGatilhoAcaoLeitura;
    }

    public String getCaminhoUsuarioDestinatario() {
        return caminhoUsuarioDestinatario;
    }

    public void setCaminhoUsuarioDestinatario(String caminhoUsuarioDestinatario) {
        this.caminhoUsuarioDestinatario = caminhoUsuarioDestinatario;
    }

}
