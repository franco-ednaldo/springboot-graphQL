package com.example.compras.graphQL.exception;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GenericGraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import graphql.validation.ValidationError;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GraphQLHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list.stream()
                .map(this::getErrors)
                .collect(Collectors.toList());
    }

    private GraphQLError getErrors(GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching) {
            var exceptionError = (ExceptionWhileDataFetching) error;
            if (exceptionError.getException() instanceof DomainException) {
                Throwable ex = exceptionError.getException();
                String msg = ex.getMessage();
                return new SimpleError(msg);
            }
            return new SimpleError("Ocorreu um erro ao processar transação");
        } else if (error instanceof ValidationError) {
            var message = error.getMessage();
            return new SimpleError(message);
        }
        return error;
    }
}

class SimpleError extends GenericGraphQLError {

    public SimpleError(String message) {
        super(message);
    }

    @Override
    @JsonIgnore
    public List<Object> getPath() {
        return null;
    }

    @Override
    @JsonIgnore
    public Map<String, Object> getExtensions() {
        return null;
    }
}
