/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasapp.dao;

import java.util.List;
import tugasapp.model.uangkas;

/**
 *
 * @author wardatumilah
 */
public interface tugasdao {

    List<uangkas> get();

    uangkas getSinggle(int id);

    boolean save(uangkas uangkas);

    boolean update(uangkas uangkas);

    boolean delete(int id);

}
