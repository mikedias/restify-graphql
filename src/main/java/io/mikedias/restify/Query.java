package io.mikedias.restify;

import io.leangen.graphql.annotations.GraphQLQuery;

import java.util.List;

public class Query {

    private final ContributorRepository contributorRepository;

    public Query(ContributorRepository contributorRepository) {
        this.contributorRepository = contributorRepository;
    }

    @GraphQLQuery
    public List<Contributor> allContributors(String owner, String repository) {
        return contributorRepository.getAllContributors(owner, repository);
    }

}
