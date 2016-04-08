package br.carneiro.argentum.bean;

import javax.faces.bean.ManagedBean;

/**
 * Created by heitor on 05/04/16.
 */
@ManagedBean
public class RedirectBean
{
    private final static String REDIRECT = "?faces-redirect=true";
    private String parametro;

    public void buscar()
    {
        System.out.println("PARAMETRO:" + getParametro());
    }

    /**
     * Buscar
     */

    private String redirectTo(String url)
    {
        return "/".concat(url).concat(REDIRECT);
    }

    /**
     * URL TO REDIRECT
     */

    public String index()
    {
        return redirectTo("index");

    }

    public String cadastrar()
    {
        return redirectTo("cadastro");
    }

    public String analisar()
    {
        return redirectTo("negociacao");
    }

    public String argentum()
    {
        return redirectTo("argentum");
    }

    /**
     * Getters and Setters
     */
    public String getParametro()
    {
        return parametro;
    }

    public void setParametro(String parametro)
    {
        this.parametro = parametro;
    }
}
