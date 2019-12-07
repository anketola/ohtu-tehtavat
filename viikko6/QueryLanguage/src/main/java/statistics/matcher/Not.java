/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author hotaru
 */
public class Not implements Matcher {
    
  private Matcher[] matchers;

  public Not(Matcher... matchers) {
    this.matchers = matchers;
  } 
    
  @Override
  public boolean matches(Player p) {
    for (Matcher entry : matchers) {
      if (entry.matches(p)) {
        return false;
      }
    }  
    return true;
  }  
   
}
