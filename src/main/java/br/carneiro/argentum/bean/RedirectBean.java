package br.carneiro.argentum.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by heitor on 05/04/16.
 */
@ManagedBean
@SessionScoped
public class RedirectBean implements Serializable
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
        return redirectTo("cadastrar");
    }

    public String negociacao()
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
