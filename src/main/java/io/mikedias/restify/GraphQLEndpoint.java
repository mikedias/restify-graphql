package io.mikedias.restify;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.mikedias.restify.github.GithubContributorRepository;
import io.mikedias.restify.gitlab.GitlabContributorRepository;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    private static final long serialVersionUID = 1L;

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {

        GithubContributorRepository githubContributorRepository = new GithubContributorRepository();
        GitlabContributorRepository gitlabContributorRepository = new GitlabContributorRepository();

        Query query = new Query(githubContributorRepository, gitlabContributorRepository); //create or inject the service beans

        return new GraphQLSchemaGenerator()
                .withOperationsFromSingletons(query) //register the beans
                .generate();

    }


}
