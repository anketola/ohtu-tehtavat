/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.PlaysIn;

/**
 *
 * @author hotaru
 */
public class QueryBuilder {

  Matcher matcher;
  
  public QueryBuilder() {
   this.matcher = new All();
  }
  
  public Matcher build() {
    return this.matcher;
  }
   
  public QueryBuilder playsIn(String team) {
    this.matcher = new And(this.matcher, new PlaysIn(team));
    return this;
  }
  
  public QueryBuilder hasAtLeast(int score, String category) {
    this.matcher = new And(this.matcher, new HasAtLeast(score, category));
    return this;
  }
  
  public QueryBuilder hasFewerThan(int score, String category) {
    this.matcher = new And(this.matcher, new HasFewerThan(score, category));
    return this;
  }
    
}
