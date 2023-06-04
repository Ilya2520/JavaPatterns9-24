#### Stage 1: Build the application
From openjdk:19 build
# Set the current working directory inside the image WORKOIR /app

# Copy maven executable to the image
COPY mvnW .
COPY .mvn .mvn
# Copy the pom.xml file
COPY pom.xml .

# Build all the dependencies in preparation to go offline. 15 # This is a separate step so the dependencies will be cached unless
# the pom.xml file has changed.

RUN ./mvnw dependency:go-offline -B
# Copy the project source
COPY src src

# Package the application 23 RUN ./mvnw package -DskipTests 24 RUN mkdir -p target/dependency && (cd target/dependency; jar -xf …/*.jar)
#### Stage 2: A minimal docker image with command to run the app 27 FROM openjdk:19
ARG DEPENDENCY=/app/target/dependency # Copy project dependencies from the build stage

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","ru.emelyanov.notebook.Notebook.NotebookApplication"]
