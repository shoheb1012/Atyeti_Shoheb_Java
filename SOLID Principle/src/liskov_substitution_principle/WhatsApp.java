package liskov_substitution_principle;

public class WhatsApp extends SocialMedia{
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost() {
   //Not applicable   it means whatsaap cannot the substitute the parent beacuse both functionality can not subsitite each other
    }

    @Override
    public void senPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall(String... users) {

    }
}
