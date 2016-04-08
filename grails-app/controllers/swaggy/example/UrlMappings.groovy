package swaggy.example

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //NOTE small camelCase
        //swaggy won't see urls correctly if you start controller name with capital letter
        "/api/test/"(controller: "test", action: "testGetMethod")
        "/api/test/"(controller: "test", action: "testPostMethod")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
