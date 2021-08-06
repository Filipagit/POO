package f4;

import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
/**
 * Escreva a descrição da classe SistemadeSuporte aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class SistemadeSuporte
{
   private List <PedidodeSuporte> pedidos;
   
   public SistemadeSuporte(List<PedidodeSuporte> pedidos) {
        this.setPedidos(pedidos);
    }
   
   public SistemadeSuporte(){
       this.pedidos= new ArrayList<>();
    }
      public SistemadeSuporte(SistemadeSuporte s){
        this.setPedidos(s.getPedidos());
    }
   public List<PedidodeSuporte> getPedidos(){
      return this.pedidos;
    }
   public SistemadeSuporte clone(){
       return new SistemadeSuporte(this);
    }
   public void setPedidos(List<PedidodeSuporte> pedidos){
       this.pedidos=new ArrayList<>();
        for(PedidodeSuporte p : pedidos) this.pedidos.add(p.clone());
    }
   /**
    * i) insere um novo pedido de suporte no sistema 
    */ 
   public void inserePedido(PedidodeSuporte pedido){
       this.pedidos.add(pedido.clone());
    }
   /**
    * ii) procura um pedido de suporte dada a identificacao de quem criou e o inst em que se criou
    */ 
   public PedidodeSuporte procuraPedido(String user,LocalDateTime data){
       for(PedidodeSuporte p : this.pedidos)
          if(p.getUser()==user && p.getDataI()==data) return p.clone();
          return null;
    }
   /**
    * iii) resolve um pedido de suporte indicando o tecnico e info
    */ 
   public void resolvePedido(PedidodeSuporte pedido,String tecnico, String info){
       pedido.setQtp(tecnico);
       pedido.setInfo(info);
       pedido.setDataI(LocalDateTime.now());
       int ind=procuraindice(pedido.getUser(),pedido.getDataI());
       pedidos.set(ind,pedido);
    }
   public int procuraindice(String user,LocalDateTime data){
       int i=0;
       for(PedidodeSuporte p : this.pedidos){
           if(p.getUser()==user && p.getDataI()==data) return i;
           i++;
        }
        return -1;
    }
   /**
    * iv) devolve tds os que ja foram resolvidos 
    */ 
   public List<PedidodeSuporte> resolvidos(){
       List<PedidodeSuporte> solved = new ArrayList<>();
       for(PedidodeSuporte p : this.pedidos)
       if(p.getQtp()!=null && p.getInfo()!=null && p.getDataI()!=null) solved.add(p.clone());
       return solved;
    }
   /**
    * v) devolve o colaborador que resolveu mais pedidos 
    */ 
   public String colaboradorTop(){
       String top=null;
       ArrayList<PedidodeSuporte> novo = new ArrayList<PedidodeSuporte>(this.pedidos);
         for(PedidodeSuporte p : novo)
            if(top==null || numpedidos(p.getQtp()) > numpedidos(top)) top=p.getQtp();
            return top;
}
public int numpedidos(String emp){
    int num=0;
      for(PedidodeSuporte p : this.pedidos)
          if(p.getQtp()== emp) num++;
          return  num;
        }
/**
 * vi) devolve os pedidos resolvidos num dado periodo de tempo 
 */        
public List<PedidodeSuporte> resolvidos(LocalDateTime inicio, LocalDateTime fim){
    List<PedidodeSuporte> res= new ArrayList<>();
    for(PedidodeSuporte p : this.pedidos)
       if(inicio.isBefore(p.getDataI()) && fim.isAfter(p.getDataF()))
          res.add(p.clone());
          return res;
}
/**
 * vii) calcula a media em minutos do tempo de resolucao dos pedidos
 */
public double tempoMedioResolucao(){
    List<PedidodeSuporte> s= resolvidos();
    int acc=0, totaltime=0;
      for(PedidodeSuporte p : s){
          totaltime+= diffDatas(p.getDataI(),p.getDataF());
          acc++;
}
  return (double) totaltime/acc;
}
public int diffDatas(LocalDateTime inicio, LocalDateTime fim){
    return (int) ChronoUnit.MINUTES.between(inicio,fim);
}
/**
 * viii) calcula a media de minutos... 
 */
public double tempoMedioResolucao(LocalDateTime inicio, LocalDateTime fim){
     List<PedidodeSuporte> s= resolvidos(inicio,fim);
    int acc=0, totaltime=0;
      for(PedidodeSuporte p : s){
          totaltime+= diffDatas(p.getDataI(),p.getDataF());
          acc++;
}
  return (double) totaltime/acc;
}
/**
 * ix) devolve o pedido que demorou mais tempo a ser resolvido 
 */
public PedidodeSuporte pedidoMaisLongo(){
    List<PedidodeSuporte> res= resolvidos();
    PedidodeSuporte maisl=null;
    for(PedidodeSuporte p : res){
       if(maisl==null || diffDatas(maisl.getDataI(),maisl.getDataF())<diffDatas(p.getDataI(),p.getDataF())) 
         maisl=p;
        }
    return maisl;
}
/**
 * x)devolve, dos pedidos resolvidos num determinado intervalo, o que demorou mais tempo a ser resolvido
 */
public PedidodeSuporte pedidoMaisLongo(LocalDateTime inicio, LocalDateTime fim){
    List<PedidodeSuporte> res=resolvidos(inicio,fim);
    PedidodeSuporte maisl=null;
    for(PedidodeSuporte p : res)
       if(maisl==null || diffDatas(maisl.getDataI(),maisl.getDataF())<diffDatas(p.getDataI(),p.getDataF())) 
         maisl=p;
    return maisl;
}
/**
 * xi) devolve o pedido que demorou menos tempo a resolver 
 */
public PedidodeSuporte pedidoMaisCurto(){
    List<PedidodeSuporte> res= resolvidos();
    PedidodeSuporte maisc=null;
    for(PedidodeSuporte p : res){
       if(maisc==null || diffDatas(maisc.getDataI(),maisc.getDataF())>diffDatas(p.getDataI(),p.getDataF())) 
         maisc=p;
        }
    return maisc;
}
/**
 * xii)
 */
public PedidodeSuporte pedidoMaisCurto(LocalDateTime inicio,LocalDateTime fim){
    List<PedidodeSuporte> res=resolvidos(inicio,fim);
    PedidodeSuporte maisc=null;
    for(PedidodeSuporte p : res)
       if(maisc==null || diffDatas(maisc.getDataI(),maisc.getDataF())>diffDatas(p.getDataI(),p.getDataF())) 
         maisc=p;
    return maisc;
}
}

