package io.mikedias.restify.gitlab;

import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Path;

import java.util.List;

@Path("https://gitlab.com/api/v4/")
public interface Gitlab {

    @Get
    @Path("projects/{owner}%2F{repo}/repository/contributors")
    List<GitlabContributor> contributors(String owner, String repo);

}
