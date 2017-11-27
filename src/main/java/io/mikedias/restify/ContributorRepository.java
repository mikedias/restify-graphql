package io.mikedias.restify;

import java.util.List;

public class ContributorRepository {

    private GitHub gitHub;

    public ContributorRepository(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    public List<Contributor> getAllContributors(String owner, String repository) {
        return gitHub.contributors(owner, repository);
    }

}
