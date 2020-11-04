                        import org.hibernate.Session;
                        import org.hibernate.SessionFactory;
                        import org.hibernate.cfg.Configuration;
                        import org.hibernate.service.ServiceRegistry;
                        import org.hibernate.service.ServiceRegistryBuilder;
                        public class HibernateUtil {

                            private static final SessionFactory sessionFactory;

                            static{
                                try{
                                    // Create the SessionFactory from standard (hibernate.cfg.xml)
                                    // Config file.
                                    Configuration configuration = new Configuration().configure();
                                    ServiceRegistryBuilder registry= new ServiceRegistryBuilder();
                                    registry.applySettings(configuration.getProperties());
                                    ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
                                    sessionFactory=configuration.buildSessionFactory(serviceRegistry);
                                }catch (Throwable ex) {
                                    // Log The execption.
                                    System.err.println("Intial SessionFactory creation failed."+ ex);
                                    throw new ExceptionInInitializerError(ex);
                                }
                            }
                            public static SessionFactory getSessionFactory(){
                                return sessionFactory;
                                }
                            }
