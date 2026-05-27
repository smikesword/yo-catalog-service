//package yo.com.yo_catalog_service.web;
//
//
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import yo.com.yo_catalog_service.config.SecurityConfig;
//import yo.com.yo_catalog_service.domain.BookNotFoundException;
//import yo.com.yo_catalog_service.domain.BookService;
//
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(BookController.class)
//@Import(SecurityConfig.class)
//class BookControllerMvcTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private BookService bookService;
//
//    @MockitoBean
//    JwtDecoder jwtDecoder;
//
//    @Test
//    void whenGetBookNotExistingThenShouldReturn404() throws Exception {
//        String isbn = "73737313940";
//        given(bookService.viewBookDetails(isbn)).willThrow(BookNotFoundException.class);
//        mockMvc
//                .perform(get("/books/" + isbn))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void whenDeleteBookWithEmployeeRoleThenShouldReturn204() throws Exception{
//        var isbn = "7373731394";
//        mockMvc
//            .perform(MockMvcRequestBuilders.delete("/books/" + isbn)
//                .with(jwt().authorities(new SimpleGrantedAuthority("ROLE_employee"))))
//                .andExpect(MockMvcResultMatchers.status().isNoContent());
//    }
//
//    @Test
//    void whenDeleteBookWithCustomerRoleThenShouldReturn403() throws Exception {
//        var isbn = "7373731394";
//        mockMvc
//          .perform(MockMvcRequestBuilders.delete("/books/" + isbn)
//                .with(SecurityMockMvcRequestPostProcessors.jwt()
//                        .authorities(new SimpleGrantedAuthority("ROLE_customer"))))
//                .andExpect(MockMvcResultMatchers.status().isForbidden());
//    }
//
//    @Test
//    void whenDeleteBookNotAuthenticatedThenShouldReturn401() throws Exception {
//        var isbn = "7373731394";
//        mockMvc
//            .perform(MockMvcRequestBuilders.delete("/books/" + isbn))
//            .andExpect(MockMvcResultMatchers.status().isUnauthorized());
//    }
//
//
//
//}
