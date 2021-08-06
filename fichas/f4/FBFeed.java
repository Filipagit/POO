package f4;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Escreva a descrição da classe FBFeed aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class FBFeed
{
    private ArrayList<FBPost> feed;

	public FBFeed(){
		this.feed = new ArrayList<>();
	}

	public FBFeed(ArrayList<FBPost> feed){
		this.feed = feed;
	}
         public ArrayList<FBPost> getFeed(){
		ArrayList<FBPost> feed = new ArrayList<>();
		for(FBPost f : this.feed)
			feed.add(f);
		return feed;
	}
    /**
     * i) determinar o nr de posts de um user 
     */
    public int nrPosts(String user){
        int num=0;
        for(FBPost p : this.feed)
           if(p.getNome().equals(user))
           num++;
           return num;
}
/**
 * ii) deteminar a lista de posts de um user 
 */
public List<FBPost> postsOf(String user){
    List<FBPost> novo= new ArrayList<>();
    for(FBPost f : this.feed){
        if(f.getNome().equals(user))
        novo.add(f.clone());
}
return novo;
}
/**
 * iii) determinar a lista de posts de um user num determinado intervalo de tempo 
 */
public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
    List<FBPost> novo= new ArrayList<>();
    LocalDateTime date;
    for(FBPost f : this.feed){
        if(f.getNome().equals(user)){
         date=f.getData();
         if(!(date.isBefore(inicio) && !(date.isAfter(fim))))
         novo.add(f);
        }
    }
    return novo;
}
/**
 * iv) obter um post dado o seu id 
 */
public FBPost getPost(int id){
    FBPost novo = new FBPost();
    for(FBPost f : this.feed){
        if(f.getID()==id)
         novo=f;
        }
        return novo;
    }
/**
 * v) inserir um comentario num post 
 */    
public void comment(FBPost post, String comentario){
        post.getComentarios().add(comentario);
}
/**
 * vi) inserir um comentario num post 
 */
public void comment(int postid ,String comentario){
       comment(getPost(postid),comentario);
}
/**
 * vii) adicionar um like ao post 
 */
public void like(FBPost post){
    int likes=post.getNumLikes();
    likes++;
    post.setNumLikes(likes);
}
/**
 * viii) 
 */
public void like(int postid){
    like(getPost(postid));
}
/**
 * ix)determinar a lista dos 5 posts c mais comentarios 
 */
public List<Integer> top5CommentsExt() {
        ArrayList<FBPost> copy = new ArrayList<>(this.feed);
        List<Integer> top5 = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            FBPost mostCommented = null;
            for(FBPost post : copy)
                if(mostCommented == null || mostCommented.getComentarios().size() < post.getComentarios().size())
                    mostCommented = post;
            top5.add(mostCommented.getID());
            copy.remove(mostCommented);
        }
        return top5;
    }
}


