/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.dto;

/**
 *
 * @author Mobby
 */
public enum SocialMediaService {

    FACEBOOK("facebook"), TWITTER("twitter"), LINKEDIN("linkedin"), GOOGLE("google"), NONE("local");

    private String providerType;

    public String getProviderType() {
        return providerType;
    }

    SocialMediaService(final String providerType) {
        this.providerType = providerType;
    }

}
