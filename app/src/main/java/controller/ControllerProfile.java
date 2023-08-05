package controller;

import android.net.Uri;

public class ControllerProfile {

    private Uri UserImageProfile;
    private String Nome;
    private String Email;
    private String telefone;

    public ControllerProfile(Uri userImageProfile, String nome, String email, String telefone) {
        UserImageProfile = userImageProfile;
        Nome = nome;
        Email = email;
        this.telefone = telefone;
    }

    public Uri getUserImageProfile() {
        return UserImageProfile;
    }

    public void setUserImageProfile(Uri userImageProfile) {
        UserImageProfile = userImageProfile;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
