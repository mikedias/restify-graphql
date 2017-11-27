package io.mikedias.restify;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.mikedias.restify.github.GithubContributorRepository;
import io.mikedias.restify.gitlab.GitlabContributorRepository;

import javax.servlet.annotation.WebServlet;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    private static final long serialVersionUID = 1L;

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {

        GithubContributorRepository githubContributorRepository = new GithubContributorRepository();
        GitlabContributorRepository gitlabContributorRepository = new GitlabContributorRepository();

        Query query = new Query(githubContributorRepository, gitlabContributorRepository);

        return new GraphQLSchemaGenerator()
                .withOperationsFromSingletons(query)
                .generate();

    }

    @Override
    protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
        return errors.stream()
                .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
                .map(e -> e instanceof ExceptionWhileDataFetching ? new SanitizedError((ExceptionWhileDataFetching) e) : e)
                .collect(Collectors.toList());
    }


}
