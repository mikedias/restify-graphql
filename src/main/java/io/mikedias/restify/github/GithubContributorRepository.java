package io.mikedias.restify.github;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;

import java.util.List;

public class GithubContributorRepository {

    private static Github github;

    static {
        github = new RestifyProxyBuilder().target(Github.class).build();
    }

    public List<GithubContributor> getAllContributors(String owner, String repository) {
        return github.contributors(owner, repository);
    }

}
