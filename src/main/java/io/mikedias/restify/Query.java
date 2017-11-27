package io.mikedias.restify;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.mikedias.restify.github.GithubContributor;
import io.mikedias.restify.github.GithubContributorRepository;
import io.mikedias.restify.gitlab.GitlabContributor;
import io.mikedias.restify.gitlab.GitlabContributorRepository;

import java.util.List;

public class Query {

    private final GithubContributorRepository githubContributorRepository;
    private final GitlabContributorRepository gitlabContributorRepository;

    public Query(GithubContributorRepository githubContributorRepository, GitlabContributorRepository gitlabContributorRepository) {
        this.githubContributorRepository = githubContributorRepository;
        this.gitlabContributorRepository = gitlabContributorRepository;
    }

    @GraphQLQuery
    public List<GithubContributor> githubContributors(String owner, String repository) {
        return githubContributorRepository.getAllContributors(owner, repository);
    }

    @GraphQLQuery
    public List<GitlabContributor> gitlabContributors(String owner, String repository) {
        return gitlabContributorRepository.getAllContributors(owner, repository);
    }

}
