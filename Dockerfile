FROM amazoncorretto:11
RUN echo $PATH
ENV PATH="$PATH:/etc/profile"
RUN echo $PATH