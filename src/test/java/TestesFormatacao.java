
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreHtmlFormat;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author salvio
 */
public class TestesFormatacao {

    @Test
    public void teste() {

        System.out.println(UtilSBCoreHtmlFormat.gerarMarkdownDeWhatsapp("Texto com <b>negrito</b> e um <a href='https://exemplo.com'>link</a>."));

        System.out.println(UtilSBCoreHtmlFormat.retirarTagsDeHtml("Texto com <b>negrito</b> e um <a href='https://exemplo.com'>link</a>."));

    }

}
