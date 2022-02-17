/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.models.Detvta;

/**
 *
 * @author usuario
 */
public interface IDetvtaService {
    public List<Detvta> listarDetvta(); 
    public void guardar(Detvta detvta); 
    public void eliminar(Detvta detvta); 
    public Detvta encontrarDetvta(Detvta detvta); 
}
