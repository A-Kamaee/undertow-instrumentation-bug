curl --location 'http://localhost:8080/home/' \
--header 'Ot-Baggage-foo: bar' \
--header 'Ot-Tracer-SpanId: 123ec123123123d1' \
--header 'Ot-Tracer-Sampled: true' \
--header 'Ot-Tracer-TraceId: caacda228f35888f'
