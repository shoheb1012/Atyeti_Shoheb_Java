package liskov_substitution_principle.solution;

public class Facebook implements SocialMedia,SocialVideoCallManger,PostMediaManager{
    @Override
    public void publishPost(Object post) {
        
    }

    @Override
    public void chatWithFriend() {

    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall(String... users) {

    }
}
