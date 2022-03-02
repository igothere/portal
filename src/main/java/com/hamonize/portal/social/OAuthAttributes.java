// package com.hamonize.portal.social;

// import java.util.Map;

// import com.hamonize.portal.user.ROLE;
// // import com.hamonize.portal.user.SnsUser;
// import com.hamonize.portal.user.User;

// import lombok.Builder;
// import lombok.Getter;

// @Getter
// public class OAuthAttributes {
//     private Map<String, Object> attributes; // OAuth2 반환하는 유저 정보 Map
//     private String nameAttributeKey;
//     private String name;
//     private String email;
//     private String picture;

//     @Builder
//     public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
//         this.attributes = attributes;
//         this.nameAttributeKey = nameAttributeKey;
//         this.name = name;
//         this.email = email;
//         this.picture = picture;
//     }

//     public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){
//         // kakao         
//         // if("kakao".equals(registrationId)){
//             return ofKakao("id", attributes);
//         // }
//         // // naver
//         // if("naver".equals(registrationId)){
//         //     return ofNaver("id", attributes);
//         // }
//         // // google
//         // return ofGoogle(userNameAttributeName, attributes);
//     }
    
//     // (new!)
//     private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
//         // kakao는 kakao_account에 유저정보가 있다. (email)
//         Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
//         // kakao_account안에 또 profile이라는 JSON객체가 있다. (nickname, profile_image)
//         Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");

//         return OAuthAttributes.builder()
//                 .name((String) kakaoProfile.get("nickname"))
//                 .email((String) kakaoAccount.get("email"))
//                 .picture((String) kakaoProfile.get("profile_image_url"))
//                 .attributes(attributes)
//                 .nameAttributeKey(userNameAttributeName)
//                 .build();
//     }
    

//     public User toEntity(){
//         return SnsUser.builder()
//                 .name(name)
//                 .email(email)
//                 .picture(picture)
//                 .role(ROLE.USER.getValue()) 
//                 .build();
//     }
   
// }
