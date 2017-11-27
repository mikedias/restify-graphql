package io.mikedias.restify.gitlab;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;

import java.util.List;

public class GitlabContributorRepository {

    private static Gitlab gitlab;

    static {
        gitlab = new RestifyProxyBuilder().target(Gitlab.class).build();
    }

    public List<GitlabContributor> getAllContributors(String owner, String repository) {
        return gitlab.contributors(owner, repository);
    }

}
