package liskov_substitution_principle;

public class Instagram extends SocialMedia
{
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost() {

    }

    @Override
    public void senPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall(String... users) {

        //not applicable unsupported feature so it is is not subsituting the parent class both functinality cannont substitue each other
    }
}
