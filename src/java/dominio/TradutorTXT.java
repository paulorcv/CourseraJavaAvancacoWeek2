package dominio;

import excecoes.TradutorException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TradutorTXT implements Tradutor{

    private static final String _arquivoComPalavras = "palavras.txt";
    BufferedReader bufferDeLeitura;
    
    @Override
    public String traduzirPalavra (String palavra) throws TradutorException{
        
        String palavraTraduzida = "";
        try {
            abrirArquivoPraLeitura();
            palavraTraduzida = palavra;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TradutorTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new TradutorException("Erro para abrir arquivo para leitura ("+ _arquivoComPalavras+ "): FileNotFoundException");
        }
        
        return palavraTraduzida;
    }

    private void abrirArquivoPraLeitura() throws FileNotFoundException {
            bufferDeLeitura = new BufferedReader(new FileReader(_arquivoComPalavras));
    }

}
