package io.mikedias.restify;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import io.leangen.graphql.GraphQLSchemaGenerator;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    private static GitHub gitHub;

    static {
        gitHub = new RestifyProxyBuilder().target(GitHub.class).build();
    }

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        ContributorRepository contributorRepository = new ContributorRepository(gitHub);
        Query query = new Query(contributorRepository); //create or inject the service beans

        return new GraphQLSchemaGenerator()
                .withOperationsFromSingletons(query) //register the beans
                .generate();

    }


}
