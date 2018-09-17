package id.rackspira.belajargraphql.service

class QueryService {

    fun queryRepository(ownerName: String, repoName: String): String {

        val query = "query {" +
                "repository(owner:\"$ownerName\", name:\"$repoName\") {" +
                "name" +
                " description" +
                " forkCount" +
                " url" +
                "  }" +
                "}"

        return query
    }

}