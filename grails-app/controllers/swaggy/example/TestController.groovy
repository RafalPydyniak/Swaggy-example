package swaggy.example

import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiImplicitParam
import com.wordnik.swagger.annotations.ApiImplicitParams
import com.wordnik.swagger.annotations.ApiOperation
import com.wordnik.swagger.annotations.ApiResponse
import com.wordnik.swagger.annotations.ApiResponses
import grails.converters.JSON

@Api("test methods")
class TestController {
    static allowedMethods = [testGetMethod: "GET", testPostMethod: "POST"]

    @ApiOperation(value = "some method description")
    @ApiResponses([
            @ApiResponse(code = 405, message = "Bad method. Only POST is allowed"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 400, message = "Invalid request json")
    ])
    def testGetMethod() {
        render([status: "OK"] as JSON)
    }

    @ApiOperation(value = "Adds plan to database", httpMethod = "POST")
    @ApiResponses([
            @ApiResponse(code = 405, message = "Bad method. Only POST is allowed"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 400, message = "Invalid request json")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = "JSON")
    ])
    def testPostMethod() {
        def json = request.JSON
        //...
    }
}
